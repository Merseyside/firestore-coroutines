package com.merseyside.firestore

/**
 * We have to initialize all properties in constructor in order to deserialize object
 */
interface IFirestoreInstance {
    var documentPath: String?
}