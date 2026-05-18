package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// We use urlPatterns to pass multiple routes. 
// "" maps to the exact root of the project, "/hello" is standard, and "/api/hello" is our JSON endpoint.
@WebServlet(urlPatterns = {"", "/hello", "/api/hello"})
public class HelloWorldServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Figure out exactly which URL the browser requested
        String path = request.getServletPath();
        
        // Route the request to the correct helper method
        if ("/api/hello".equals(path)) {
            sendJsonResponse(response);
        } else {
            sendHtmlResponse(response);
        }
    }

    // --- Helper Methods ---
    
    private void sendJsonResponse(HttpServletResponse response) throws IOException {
        // Tell the browser to expect JSON, not HTML
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8"); 
        
        // Manually write a JSON string
        String jsonString = "{ \"status\": \"success\", \"message\": \"Hello from the Java API!\", \"data\": { \"id\": 1, \"role\": \"admin\" } }";
        
        PrintWriter out = response.getWriter();
        out.print(jsonString);
        out.flush(); // Forces the server to send the data immediately
    }

    private void sendHtmlResponse(HttpServletResponse response) throws IOException {
        // Standard HTML response
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Java Routing</title></head>");
        out.println("<body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<p>This HTML is served from both the root (/) and (/hello).</p>");
        out.println("<p>Try navigating to <b>/api/hello</b> to see the JSON response!</p>");
        out.println("</body>");
        out.println("</html>");
    }
}