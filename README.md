# Secret Santa

Spring Boot Backend Application


## Overview


**Secret Santa App** helps users create multiple groups among themshelves and play the game of "Secret Santa". An user can use this app to play the "Secret Santa" game and gift other users, check wishlist of gift recipents, submit wishlists, etc. To use this app, an user has to register with the application and sign in to it.


## Technologies Used


* Java 
* Spring Boot
* Eureka Server
* Eureka Client
* REST API


## Features


* Users can register to our system, and sign in to it.
* Users can create multiple groups to play the game of Secret Santa.
* In each group, the creator will specify certain details viz. Group Title, Group Name, Group joining Deadline, Wishlist Submission Deadline.
* Any user of our system can join a group by specifying the Group Name.
* Once a group gets deleted, the associated group name has to be released and made available again.
* Our system would be able to prevent any attempt to create multiple groups with the same name.
* The group name has to be unique, throughout our system. No two groups can have the same name.
* Users would be able to get a suggestion of a unique group name from the system, that is not taken by anyone.
* The group gets deleted when the gifts are given out by all the ‘Santas’.
* A user can view the names of all other members of the group.
* A user can view all the groups that the user is attached to.
* All users would be able to submit their respective wishlists in the system, wherein, they specify the gifts they want and also specify the priority of each gift item, within the deadline of wishlist submission.
* After the wishlist submission deadline, the system would randomly assign every user as the ‘Santa’ of some other user. The user can become its own ‘Santa’.
* The Santa would be able to see the identity and wishlist of the user who would receive the gift(s) from it.
* The Santa would be able to gift the items to the gift recipient.
* The Santa would be able to check whether it has gifted its mapped gift recipient or not.
* The user would be able to check whether its ‘Santa’ has gifted it or not.


## REST API Contracts

METHOD | ROUTE | DESCRIPTION 
------------|-----|------------
POST | /user-signup | Mapping to enable user to sign up.
POST | /user-signin/email | Mapping to enable user to sign in using email.
POST | /user-signin/username | Mapping to enable user to sign in using username.
POST | /group/create/{userId} | Mapping to enable user to create a group.
DELETE | /group/{groupId} | Mapping to delete a group.
PUT | /group/join/{userId} | Mapping to enable user to join a group.
POST | /group/assign-santa/{groupId} | Mapping by which system gets a random and different santa assigned to all users.
GET | /group/{groupId}/santa/{santaId}/gift | Mapping by which Santa gifts in a group.
POST | /group/create/user | Mapping to enable user-auth microservice to register user in group-activities microservice.
GET | /group/details/{groupId} | Mapping to get details of a group.
GET | group/participant-of-group/{userId} | Mapping to enable user to see all groups with which the user is attached.
PUT | group/is-gifted/user/{userId}/group/{groupId} | Mapping to enable User/Santa to check if it got/given the gift.
POST | /group/wishlist/{userId}/group/{groupId} | Mapping to enable User to submit its wishlist of gifts.
GET | /group/wishlist/{userId}/{groupId} | Mapping to enable Santa to check the wishlist of the gift recipent.
GET | /groupname/generate/random | Mapping to get a random groupname which is unique or untaken by any other group.
POST | /groupname/check | Mapping to check whether a group name is taken or not.
POST | /groupname/assign | Mapping to check whether a group name is untaken and assign it to a new group.
POST | /groupname/release | Mapping to a group name after a group is deleted and mark it as not taken.


## Developed by


* Prottay Ray
* Caryn Dsouza
* Gautam Ankit Singh
