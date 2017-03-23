import java.util.*;
public class longestValidSubstring{
	public static int findMaxLength(String input){
		Stack<Integer> s = new Stack(); // create stack
		s.push(-1); // initialize with -1 index
		int maxLength = 0;
		for(int i = 0; i < input.length(); i++){
			// if opening bracket, store current index
			if(input.charAt(i) == '('){
				s.push(i);
			}
			// if closing bracket
			else{
				s.pop(); // remove previous bracket's index
				// if stack is not empty, update max length
				if(!s.isEmpty()){
					maxLength = Math.max(maxLength, i-s.peek());
				}
				// store current index
				else{
					s.push(i);
				}
			}
		}
		return maxLength;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // test cases
		while(t > 0){
			String input = sc.next(); // input string
			System.out.println(findMaxLength(input));
			t--;
		}
	}
}
