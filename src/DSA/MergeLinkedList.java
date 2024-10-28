package DSA;

//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
        import java.io.*;

class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}


class MergeLinkedList
{
    Node head;

    void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
    public  static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        MergeLinkedList list = new MergeLinkedList();
        while(t>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0;i<N;i++)
                arr[i] = sc.nextInt();

            Node temp = null;
            Node tempB = null;
            Node pre = null;
            Node preB = null;
            int flag=1;
            int flag1=1;
            for(int i=0; i<N;i++)
            {
                int m = arr[i];
                m--;
                int a1 = sc.nextInt();
                temp = new Node(a1);
                if(flag == 1)
                {
                    list.head = temp;
                    pre = temp;
                    flag = 0;
                    flag1 = 1;
                }
                else
                {
                    pre.next = temp;
                    pre = temp;
                    flag1 = 1;
                }

                for(int j=0;j<m;j++)
                {
                    int a = sc.nextInt();
                    tempB = new Node(a);
                    if(flag1 == 1)
                    {
                        temp.bottom = tempB;
                        preB = tempB;
                        flag1 = 0;
                    }
                    else
                    {
                        preB.bottom = tempB;
                        preB = tempB;
                    }
                }

            }
            //list.printList();
            GfG g = new GfG();
            Node root = g.flatten(list.head);
            list.printList(root);

            t--;
        }
    }
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;

	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
class GfG
{
    Node flatten(Node root)
    {
        if(root.next == null) {
            return root;
        }

        root.next = flatten(root.next);
        root = mergeTwoLists(root, root.next);
        return root;
    }

    Node mergeTwoLists(Node currA, Node currB) {
        Node result = null;
        Node head = null;

        while(currA != null && currB != null) {
            if(currA.data > currB.data) {
                if(result == null) {
                    result = new Node(currB.data);
                    head = result;
                } else {
                    result.bottom = new Node(currB.data);
                    result = result.bottom;
                }
                currB = currB.bottom;
            } else {
                if(result == null) {
                    result = new Node(currA.data);
                    head = result;
                } else {
                    result.bottom = new Node(currA.data);
                    result = result.bottom;
                }
                currA = currA.bottom;
            }
        }
        if(currA != null) {
            result.bottom = currA;
        }

        else {
            result.bottom = currB;
        }

        return head;
    }
}
