## 1. I used math.js Web API.
2. I used ExecutorService to manage the concurrency of API requests. I created a fixed-size thread pool that respects the API's rate limit (e.g., 50 threads) to send requests concurrently, used throttling mechanism also.
3. I used URLEncoder to encode the expression before appending it to the URL. This method replaces special characters such as +, /, and ^ with their corresponding URL-encoded forms (%2B, %2F, %5E respectively). This ensures that the expressions are properly formatted for the API request
