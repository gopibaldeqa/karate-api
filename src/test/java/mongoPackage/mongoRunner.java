package mongoPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

public class mongoRunner {

	private static final Logger logger = LoggerFactory.getLogger(mongoRunner.class);
	private MongoClient mongoClient;

	public mongoRunner(Map<String, Object> config) {
		String host = (String) config.get("host");
		int port = (int) config.get("port");
		mongoClient = new MongoClient(host, port);
	}

	public void insertValues(String database, String collection, List<Object> query) {
		List<Document> documents = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			for (Object object : query) {
				String documentString = objectMapper.writeValueAsString(object);
				Document doc = Document.parse(documentString);
				documents.add(doc);
			}
		} catch (IOException e) {
			logger.error("Error in parsing document for collection");
		}
		mongoClient.getDatabase(database).getCollection(collection).insertMany(documents);
	}

	public void deleteDocuments(String database, String collection, String field, Iterable<String> ids) {
		mongoClient.getDatabase(database).getCollection(collection).deleteMany(in(field, ids));
	}

	public String getId(String database, String collection, String field, String value) {
		FindIterable<Document> documents = mongoClient.getDatabase(database).getCollection(collection)
				.find(eq(field, value));
		String id = "";
		for (Document document : documents) {
			id = document.get("alertMetric").toString();

		}
		return id;
	}

	public void disconnect() {
		mongoClient.close();
	}

}
