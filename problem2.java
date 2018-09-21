package LeeCode;

/*
 * 两数相加：
 * 给定两个非空链表来表示两个非负整数，位数按照逆序方式存储
 * 它们的每个节点只存储单个数字。将两数相加返回一个新的链表
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头
 */

public class problem2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;

		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;

		Solution2 solution2 = new Solution2();
		ListNode l7 = solution2.addTwoNumbers(l1, l4);
		while (l7 != null) {
			System.out.print(l7.val);
			l7 = l7.next;
		}
	}
}

// 链表节点形式
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = null;
		if (l1 == null || l2 == null) {
			return res;
		}
		// 进位标志
		int flag = 0;
		res = new ListNode(0);
		ListNode curr = res;
		// 每一位的和
		int sum = 0;
		while (l1 != null || l2 != null) {
			// 按位加
			int val1 = l1 == null ? 0 : l1.val;
			int val2 = l2 == null ? 0 : l2.val;
			if (flag == 0) {
				sum = val1 + val2;
			} else {
				sum = val1 + val2 + 1; // 别忘记加进位
			}
			if (sum >= 10) {
				flag = 1; // 设置进位
				sum = sum % 10;
			} else {
				flag = 0; // 没有进位时，别忘了把标志置0
			}
			curr.next = new ListNode(sum);
			curr = curr.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		// 最高位有可能产生进位，如555+555
		if (flag == 1) {
			curr.next = new ListNode(1);
		}
		return res.next;
	}
}