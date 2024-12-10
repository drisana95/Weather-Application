package com.savvycodes.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Endpoint for Hello World
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    // Endpoint for displaying a simple weather page (without API)
    @GetMapping("/weather")
    public String weather() {
        // Weather data for multiple cities (static data)
        String[][] leftCities = {
            {"New York", "18°C", "60%", "Clear Sky"},
            {"Los Angeles", "22°C", "50%", "Sunny"},
            {"Chicago", "12°C", "65%", "Cloudy"},
            {"Miami", "28°C", "70%", "Rainy"}
        };

        String[][] rightCities = {
            // Group 1 - Leftmost side
            {"San Francisco", "16°C", "55%", "Foggy"},
            {"Dallas", "30°C", "40%", "Hot"},
            {"Boston", "10°C", "72%", "Windy"},
            
            // Group 2 - Middle
            {"Austin", "32°C", "45%", "Sunny"},
            {"Seattle", "14°C", "80%", "Showers"},
            {"Orlando", "29°C", "60%", "Clear"},
            {"India", "30°C","80%","Clear"} ,
            
            // Group 3 - Rightmost side
            {"Phoenix", "35°C", "30%", "Hot"},
            {"Washington, D.C.", "20°C", "50%", "Partly Cloudy"},
            {"Las Vegas", "40°C", "25%", "Very Hot"},
            {"Denver", "8°C", "35%", "Snowy"}
        };

        // HTML content displaying weather information for each city in three columns
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<html>")
                   .append("<head><title>Weather Information</title>")
                   .append("<style>")
                   .append("body { font-family: Arial, sans-serif; background-color: #f0f8ff; padding: 20px; text-align: center; }")
                   .append("h1 { color: #0000FF; }")
                   .append("h2 { color: #0000FF; }")
                   .append("p { font-size: 18px; color: #0000FF; }")
                   .append(".container { display: flex; justify-content: space-between; gap: 50px; }") // Flex container for three groups with space between
                   .append(".group { display: flex; flex-direction: column; align-items: flex-start; gap: 20px; width: 30%; }") // Styling each group with equal width
                   .append(".right-group { display: flex; flex-direction: column; align-items: flex-start; gap: 20px; width: 30%; }") // Right group width adjustment
                   .append(".right-group img { width: 150px; height: 150px; border-radius: 10px; margin-top: 20px; object-fit: contain; }") // Adjust image size and preserve aspect ratio
                   .append("</style>")
                   .append("</head>")
                   .append("<body><h1>Weather Information</h1>")
                   .append("<div class='container'>");

        // Left Column
        htmlContent.append("<div class='group'>");
        for (String[] city : leftCities) {
            htmlContent.append("<h2>Weather in " + city[0] + "</h2>")
                       .append("<p><strong>Temperature:</strong> " + city[1] + "</p>")
                       .append("<p><strong>Humidity:</strong> " + city[2] + "</p>")
                       .append("<p><strong>Condition:</strong> " + city[3] + "</p>")
                       .append("<br>");
        }
        htmlContent.append("</div>");

        // Middle Column
        htmlContent.append("<div class='group'>");
        for (int i = 3; i < 6; i++) {
            htmlContent.append("<h2>Weather in " + rightCities[i][0] + "</h2>")
                       .append("<p><strong>Temperature:</strong> " + rightCities[i][1] + "</p>")
                       .append("<p><strong>Humidity:</strong> " + rightCities[i][2] + "</p>")
                       .append("<p><strong>Condition:</strong> " + rightCities[i][3] + "</p>")
                       .append("<br>");
        }
        htmlContent.append("</div>");

        // Right Column with Image
        htmlContent.append("<div class='right-group'>");
        for (int i = 6; i < rightCities.length; i++) {
            htmlContent.append("<h2>Weather in " + rightCities[i][0] + "</h2>")
                       .append("<p><strong>Temperature:</strong> " + rightCities[i][1] + "</p>")
                       .append("<p><strong>Humidity:</strong> " + rightCities[i][2] + "</p>")
                       .append("<p><strong>Condition:</strong> " + rightCities[i][3] + "</p>")
                       .append("<br>");
        }
        // Add image to the right-most side
        htmlContent.append("<img src='/static/Screenshot_2024_11_10_215719.png' alt='Weather Icon'/>");

        htmlContent.append("</div>");

        htmlContent.append("</div>") // Close the container div
                   .append("</body>")
                   .append("</html>");

        return htmlContent.toString();
    }
}
