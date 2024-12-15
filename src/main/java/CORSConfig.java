import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CORSConfig implements WebMvcConfigurer{
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/courses") // Specify the endpoint you want to allow CORS for
                .allowedOrigins("*"); // Allow requests from all origins
        
        registry.addMapping("/courses/{courseId}")
        .allowedOrigins("*"); 
    }
}
