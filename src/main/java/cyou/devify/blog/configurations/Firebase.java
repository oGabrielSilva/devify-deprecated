package cyou.devify.blog.configurations;

import java.io.FileInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class Firebase {
    @Bean
    FirebaseApp requireApp() {
        if (FirebaseApp.getApps().isEmpty()) {
            try {

                FileInputStream serviceAccount = new FileInputStream("./firebase-sdk-admin.json");

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                return FirebaseApp.initializeApp(options);
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        } else {
            return FirebaseApp.getApps().get(0);
        }

    }
}
