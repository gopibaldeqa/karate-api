function fn() {
	var environment = karate.env; // get java system property 'karate.env'
	karate.log('karate.env system property was:', karate.env);

	var config = {
		//QA base url
		baseURL: 'https://baseUrl'
	};
	if (environment == "QA") {

		// environment urls 
		config.baseURL = 'https://baseUrl'

	} else {
		if (environment == "DI") {
			var config = {

				baseURL: 'https://baseUrl',

			};

		}
	}

	karate.configure('connectTimeout', 80000);
	karate.configure('readTimeout', 80000);

	return config;
}