function fn() {
    karate.log('Configuring Karate')
    var config = {
        baseUrl : 'http://localhost:8080/api'
    };

    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
