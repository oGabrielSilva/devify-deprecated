package cyou.devify.blog.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;

import cyou.devify.blog.entities.Stack;

@Service
public class StackService {
    private final String collection = "stacks";

    private final Firestore db;

    public StackService(@Autowired FirebaseApp app) {
        this.db = FirestoreClient.getFirestore(app);
    }

    public List<Stack> getAll() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = db.collection(collection).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        return documents.stream().map(doc -> doc.toObject(Stack.class)).toList();
    }
}
