#include<stdio.h>
#include<stdlib.h>
#include"stack.h"
struct Node{
    void* item;
    struct Node *next;
};
static struct Node *first = NULL;
static int n = 0;

void push(void *item)
{
    struct Node *oldFirst = first;
    first = (struct Node*)malloc(sizeof(struct Node));
    first->item = item;
    first->next = oldFirst;
    n++;
}

void* pop(){
    void *item = first->item;
    first = first->next;
    n--;
    return item;
}

int isEmpty(){
    return first == NULL;
}

int size(){
    return n;
}
