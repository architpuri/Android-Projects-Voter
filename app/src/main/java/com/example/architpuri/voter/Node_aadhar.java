package com.example.architpuri.voter;
//one node of adjacency list
/*Put these nodes using bucket sort in a particular order or using hashing function for fast retrieval & make adjacency linked lists
 for fast access These nodes contain info whether vote is cast or not*/
public class Node_aadhar{
    long aadhar_no;
    protected Node_aadhar next;
    boolean vote;
    void Node()
    {
        this.aadhar_no=0;
        this.next=null;
        this.vote=false;
    }
    void Node(int d)
    {
        this.aadhar_no = d;
        this.next = null;
        this.vote = false;
    }
}
