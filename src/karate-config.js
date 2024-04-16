function fn() {
	var environment = karate.env; // get java system property 'karate.env'
	karate.log('karate.env system property was:', karate.env);

	var config = {
		//QA base url
		baseUrlTesting: 'abcd',

	};
	if (environment == "QA") {

		// environment urls 
		config.baseUrlTesting = 'hfibkwssssss'

	} else {
		if (environment == "DI") {
			var config = {

				baseUrlTesting: 'hfibkwssssss',

			};

		}
	}
config.baseUrlTesting = "abcd";
	karate.configure('connectTimeout', 80000);
	karate.configure('readTimeout', 80000);

	return config;
}