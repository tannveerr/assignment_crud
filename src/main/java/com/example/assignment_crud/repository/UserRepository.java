package com.example.assignment_crud.repository;

import com.example.assignment_crud.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ExecutionException;

@Repository
public class UserRepository {
    private static final String COLLECTION_NAME = "users";

    public String saveUser(User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(user.getId());
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture = documentReference.set(user);
        return collectionApiFuture.toString();
    }

    public User getUser(String userId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(userId);
        ApiFuture<com.google.cloud.firestore.DocumentSnapshot> future = documentReference.get();
        com.google.cloud.firestore.DocumentSnapshot document = future.get();
        return document.exists() ? document.toObject(User.class) : null;
    }

    public String updateUser(User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(user.getId());
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture = documentReference.set(user);
        return collectionApiFuture.toString();
    }

    public String deleteUser(String userId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(userId);
        ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture = documentReference.delete();
        return collectionApiFuture.toString();
    }

    public Iterable<User> getAllUsers() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).get();
        QuerySnapshot querySnapshot = future.get();
        return querySnapshot.toObjects(User.class);
    }
    
}
