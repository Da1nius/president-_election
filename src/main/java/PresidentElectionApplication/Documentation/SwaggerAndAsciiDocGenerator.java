package PresidentElectionApplication.Documentation;

public class SwaggerAndAsciiDocGenerator {
    /*
    public static void main(String[] args) throws IOException {
        Path swaggerTargetFolder = Paths.get(args[0]);
        Path asciiDocTargetFolder = Paths.get(args[1]);

        System.out.println("Creating Swagger Spec in " + swaggerTargetFolder);
        createSwagger(swaggerTargetFolder);
        System.out.println("Generating AsciiDoc in " + asciiDocTargetFolder);
        convertSwaggerToAsciiDoc(swaggerTargetFolder, asciiDocTargetFolder);
        System.out.println("Done.");
    }
/*
    private static void createSwagger(Path swaggerTargetFolder) throws IOException {
        BeanConfig config = new BeanConfig();
        config.setVersion("v1");
        config.setTitle("Band API");
        config.setDescription("An API to retrieve and create bands.");
        config.setSchemes(new String[]{"http"});
        config.setHost("localhost:8080");
        config.setBasePath("");
        config.setResourcePackage("de.philipphauer.blog.resources");
        config.setScan();//this "setter" triggers the scanning... nice naming...
        Swagger swagger = config.getSwagger();

        String json = Json.pretty().writeValueAsString(swagger);
        Path jsonFile = swaggerTargetFolder.resolve("swagger.json");
        Files.write(jsonFile, json.getBytes(StandardCharsets.UTF_8));

        String yaml = Yaml.mapper().writeValueAsString(swagger);
        Path yamlFile = swaggerTargetFolder.resolve("swagger.yaml");
        Files.write(yamlFile, yaml.getBytes(StandardCharsets.UTF_8));
    }
    private static void convertSwaggerToAsciiDoc(Path swaggerTargetFolder, Path asciiDocTargetFolder){
        Path swaggerFile = swaggerTargetFolder.resolve("swagger.json");
        Swagger2MarkupConverter.from(swaggerFile)
                .build()
                .toFolder(asciiDocTargetFolder);
    }
    */

}
