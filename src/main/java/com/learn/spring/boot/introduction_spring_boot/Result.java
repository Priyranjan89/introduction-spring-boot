package com.learn.spring.boot.introduction_spring_boot;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

/*📘 Description:
You are given the name of a country and a phone number. Your task is to fetch that country's calling code by querying the API and format the complete phone number in the following format:

php-template
Copy
Edit
+<callingCode> <phoneNumber>
If the country is not found, return "-1".

📥 Input:
A string country: the name of the country (e.g., "Afghanistan")

A string phoneNumber: the local phone number (e.g., "656445445")

📤 Output:
A string that contains the complete phone number in international format or "-1" if the country is not found.

🌐 API Details:
You can query country details using the following API:

arduino
Copy
Edit
https://jsonmock.hackerrank.com/api/countries?name=<country>
Example Request:

arduino
Copy
Edit
https://jsonmock.hackerrank.com/api/countries?name=Afghanistan
Sample Response:

json
Copy
Edit
{
  "page": 1,
  "per_page": 10,
  "total": 1,
  "total_pages": 1,
  "data": [
    {
      "name": "Afghanistan",
      "callingCodes": ["93"],
      ...
    }
  ]
}
If the data array is empty, it means the country was not found.

⚠ Constraints:
The country name is case-insensitive (may contain uppercase/lowercase/mixed-case).

The API returns 0 or 1 record.

You can use Gson for JSON parsing.

Use Java 11+ standard libraries.

🧪 Example:
Input

nginx
Copy
Edit
Afghanistan
656445445
Output

diff
Copy
Edit
+93 656445445*/

public class Result {
    /*
     * Complete the 'getPhoneNumbers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING country
     *  2. STRING phoneNumber
     * Base URL for copy/paste: https://jsonmock.hackerrank.com/api/countries?name=country
     */

    public static String getPhoneNumbers(String country, String phoneNumber) {
        String url = "https://jsonmock.hackerrank.com/api/countries?name="
                + URLEncoder.encode(country, StandardCharsets.UTF_8);

        try {
            // Create HTTP client and request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Send request and receive response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON using Gson
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray data = json.getAsJsonArray("data");

            if (data.size() == 0) {
                return "-1";
            }

            JsonObject countryData = data.get(0).getAsJsonObject();
            JsonArray callingCodes = countryData.getAsJsonArray("callingCodes");

            // Get last calling code (if multiple exist)
            String code = callingCodes.get(callingCodes.size() - 1).getAsString();

            return "+" + code + " " + phoneNumber;

        } catch (Exception e) {
            return "-1";
        }

    }

}
