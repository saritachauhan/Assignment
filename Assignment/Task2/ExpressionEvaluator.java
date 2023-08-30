package ExpressionEvaluator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



class ExpressionEvaluatorHelper {

	public static void eval(List<String> expressions) {
        String apiUrl = "http://api.mathjs.org/v4/";

        ExecutorService executorService = Executors.newFixedThreadPool(50); // Maximum 50 threads

        try {
            List<Future<Result>> futures = new ArrayList<>();

    for (String expression : expressions) {
        String encodedExpression = URLEncoder.encode(expression.trim(), StandardCharsets.UTF_8);
        URL url = new URL(apiUrl + "?expr=" + encodedExpression);

        Future<Result> future = executorService.submit(() -> {
    try {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();

    if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = in.readLine();
        in.close();
        return new Result(expression, response);
    } else {
        return new Result(expression, "HTTP GET request failed with response code: " + responseCode);
    }
            } catch (Exception e) {
                return new Result(expression, e.toString());
            }
        });

                futures.add(future);
            }

    executorService.shutdown();
    executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

    // Printing the result
    for (Future<Result> future : futures) {
        Result result = future.get();
        System.out.println(result.expression+" => "+result.response);
        
    }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Result {
    String expression;
    String response;

    Result(String expression, String response) {
        this.expression = expression;
        this.response = response;
    }
    }
}




public class ExpressionEvaluator {
	 public static void main(String[] args) {
	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputExpressions = new ArrayList<>();
    try {
        System.out.println("Enter expressions end with 'end':");
        String input;
        while (!(input = reader.readLine()).equals("end")) {
            inputExpressions.add(input);
        }
            ExpressionEvaluatorHelper.eval(inputExpressions);
    } catch (Exception e) {
        e.printStackTrace();
    }
	    }
	}

