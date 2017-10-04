#include <stdio.h>
#include <stdlib.h>
struct my_list{
    int data;
    struct my_list* next;
    struct my_list* prev;

};
typedef struct my_list list;

list* newnd(int data){
    // creates temp
    list* temp =  (list *)malloc(sizeof(list));
    if(temp == NULL){
        printf("Malloc failed.");
        Exit(1);
    }
    temp->data = data;
    temp->next = NULL;
    temp->prev = NULL;


    return temp;
}

list* insert(list *head, int number){
    list *last = NULL;
    if(head == NULL){
        // if first create one
        head = last = newnd(number);
       // head->next = last;
       // last->prev = head;

    }
    else{
        // otherwise append new node
        head->next = insert(head->next, number);

    }

    return head;

}
void print(list *first){
    while(first!=NULL){
        printf("%d ", first->data);
        first = first->next;
    }

}

void main(void){

    // variables
    int count = 0;
    int num = 0;
    int data = 0;
    list *front = NULL;

    // prints
    printf("How many nodes in your list?\n");
    scanf("%d", &num);



    // loop
    for(count = 0; count < num; count++){


        printf("Please enter a number.\n");
        scanf("%d", &data);
        front = insert(front, data);

    }

    print(front);
    //printf("PREV: %d", front->prev);
}
