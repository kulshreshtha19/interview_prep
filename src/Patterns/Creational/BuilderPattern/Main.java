package Patterns.Creational.BuilderPattern;


class URLBuilder {
    public static class Builder {
        private String protocol;
        private String host;
        private String port;
        private String queryParams;
        private String pathParams;

        public URLBuilder build() {
            return new URLBuilder(this);
        }

        public Builder host(String host) {
            this.host = host;
            return this;
        }

        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        public Builder queryParams(String queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public Builder pathParams(String pathParams) {
            this.pathParams = pathParams;
            return this;
        }
    }

    public String protocol;
    public String host;
    public String port;
    public String queryParams;
    public String pathParams;

    URLBuilder(Builder builder) {
        this.host = builder.host;
        this.protocol = builder.protocol;
        this.port = builder.port;
        this.queryParams = builder.queryParams;
        this.pathParams = builder.pathParams;
    }
}

public class Main {

    public static void main(String[] args) {
        URLBuilder urlBuilder = new URLBuilder.Builder().host("host").port("8080").build();
        System.out.println(urlBuilder.port);
    }
}
