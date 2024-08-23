This test task was writed on Java 19 and SpringBoot 3.
For start you must turn on database.
Command:

        docker-compose-up

In task you have to enntites: Author and Document.
You can search documents by SearchQuery.
Example: 

    {
    "titlePrefixes": ["Sample", "Docker"],
    "authorIds": ["5d4474a4-2995-4525-884a-ea27c5908a6a"],
    "createdFrom": "2024-08-22T00:00:00Z",
    "createdTo": "2024-08-22T23:59:59Z"
    }
    
and output be like this:

    {
    "data": [
        {
            "id": "2491fc3f-020b-4577-aea4-a52c013a9e2d",
            "title": "Sample Document",
            "content": "This is a sample document content.",
            "author": {
                "id": "5d4474a4-2995-4525-884a-ea27c5908a6a",
                "name": "Ien"
            },
            "created": "2024-08-22T20:42:55.356905Z"
        },
        {
            "id": "46c65d5b-2f9d-4760-984c-5ac260d4c622",
            "title": "Docker Document",
            "content": "This is a sample document content.",
            "author": {
                "id": "5d4474a4-2995-4525-884a-ea27c5908a6a",
                "name": "Ien"
            },
            "created": "2024-08-22T20:43:55.422416Z"
        }
      ]
    }


      
