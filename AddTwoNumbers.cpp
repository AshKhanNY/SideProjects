/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* solution = new ListNode(0);
        ListNode* head = solution;
        int place = 0;
        int x, y;
        while(l1 != NULL || l2 != NULL){
            if (l1 == NULL) x = 0;
            else x = l1->val;
            if (l2 == NULL) y = 0;
            else y = l2->val;
            int temp = place + (x + y);
            solution->val = (temp)%10;
            place = 0;
            if (temp >= 10) ++place;
            if(l1){
            if(l1->next == NULL) l1 = nullptr;
            else l1 = l1->next;
            }
            if(l2){
            if(l2->next == NULL) l2 = nullptr;
            else l2 = l2->next;
            }
            if(l1 == NULL && l2 == NULL){
                if (place != 0){
                    ListNode* temp = new ListNode(place);
                    solution->next = temp;
                } 
                break;
            } else { 
                    ListNode* temp = new ListNode();          
                    solution->next = temp;
                    solution = temp;
            }
        }
        return head;
    }
};