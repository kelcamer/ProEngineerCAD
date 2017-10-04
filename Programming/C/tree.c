#include <stdio.h>
#include <stdlib.h>


struct list1{
    int data;
    struct list1 *left;
    struct list2 *right;

};
typedef struct list1 list;

list* newnd(int data){
    // creates temp
    list* temp =  (list *)malloc(sizeof(list));
    if(temp == NULL){
        printf("Malloc failed.");
        exit(1);
    }
    temp->data = data;
    temp->left = NULL;
    temp->right = NULL;


    return temp;
}
int get_num(int data){
    int number = 0;
    scanf("%d", &number);
    return number;
}
list* get_root(list *front_nod, int indicator){

    list *new_root = front_nod;
    list *temp2 = NULL;
    list *temp3 = NULL;
    list *temp4 = NULL;

    // right node doesn't seem to exist

    if(front_nod->left != NULL){
            if(indicator == 0){
                    temp2 = front_nod->right;
                    // rotates left one step
                new_root = front_nod->left;
                temp3 = new_root->right;

                if(temp3->data < new_root->data){
                temp4 = new_root;
                temp4 = temp4->left;

                while(temp4->right != NULL){
                    temp4 = temp4->left;
                }

                temp4->right = temp3;
                new_root->right = front_nod;
                }

                front_nod->right = temp2;
                // you might have more data to enter
                front_nod->left = NULL;
//////////////////////////////////////////////////





            }
            else if(indicator == 1){

                    temp2 = front_nod->left;

                    // rotates right one step
                new_root = front_nod->right;
                  temp3 = new_root->left; //30
                  printf("Temp3: %d\n", temp3->data);
              //  new_root->left = front_nod;

                temp4 = new_root; //56
                    temp4 = temp4->right;
                while(temp4->left != NULL){
                    temp4 = temp4->right;
                }
                temp4->left = temp3;
                new_root->left = front_nod;

               front_nod->left = temp2;
                front_nod->right = NULL;

////////////////////////////////////////////////////////



            }

    }



    return new_root;

}
int height(list *front){
    int left_c = 0, right_c = 0, diff_height = 0;
    while(front->left != NULL){
        left_c++;

    }
    while(front->right != NULL){
        right_c++;
    }
    diff_height = left_c - right_c;

    printf("Difference in height:%d\n", diff_height);


    return diff_height;



}

void print(list *front){

    if(front == NULL){
        return;
    }

    printf("Front->data: %d\n", front->data);
    if(front->left != NULL){
        print(front->left);
    }

    if(front->right != NULL){
        print(front->right);
    }


}
int steps(int diff_h){

    int steps = 0, flag = -99999;
    if(diff_h < 0){
            // go left
        diff_h *= -1;
        flag = 0;
    }
    else{
            // go right
        flag = 1;
    }
    if(diff_h %2 == 0){
        steps = diff_h / 2;
    }
    else{
        steps = (diff_h -1) / 2;

    }
    switch(flag){
    case 0: printf("Go %d steps left.", steps);
    case 1: printf("Go %d steps right.", steps);
    }


}
list* insert_in_tree(list *first, int num){


    if(first == NULL){
        first = newnd(num);
    }
    else{
        if(num > first->data){
            first->right = insert_in_tree(first->right, num);
        }
        if(num < first->data){
            first->left = insert_in_tree(first->left, num);
        }
        if(num == first->data){
            return;
        }

    }
    return first;


}
void print_tree(list *head){
    if(head!= NULL){

        printf("%d ", head->data);
    }
    if(head->left != NULL){
            printf("LEFT\n");
        print_tree(head->left);
    }
    if(head->right != NULL){
                    printf("RIGHT\n");
        print_tree(head->right);
    }



}
void main(void){

    int count = 0, max = 0, num1 = 0;            printf("LEFT\n");

    list *front = NULL;
    printf("How many numbers do you want to enter?\n");
    scanf("%d", &max);

    for(count = 0; count < max; count++){
        printf("Enter a number:\n");
        scanf("%d", &num1);

        front = insert_in_tree(front, num1);

    }


    front = get_root(front, 1);
    print(front);

}
