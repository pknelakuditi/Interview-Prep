package ctci.linkedlists;

public class Problems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node ll = new Node(3);
		/*for(int i =0 ; i<3 ; i++){
			ll.insertNewNode(5);
			ll.insertNewNode(4);
			//ll.insertNewNode(9-i);
		}*/
		ll.insertNewNode(2);
		ll.insertNewNode(2);
		ll.insertNewNode(2);
		ll.insertNewNode(3);
		//ll.insertNewNode(3);
		//ll.insertNewNode(3);
		System.out.println(ll.recursivePalindromeCheck(ll));
		
		//ll.printll(ll.partialSort(ll, 3));
		ll.printll(ll);
		System.out.println("kk");
		//ll.addtionOfLL(ll, ll);
	//	ll.printll(ll);
		//ll.printll();
		//ll.deleteDuplicates(ll);
		/*System.out.println(ll.kFromLast(ll, 1));
		ll.kFromLastRecursive(ll, 1);*/
		//ll.printll();
		/*ll.deleteNode(ll, 3);
		ll.printll();*/
	}

}
