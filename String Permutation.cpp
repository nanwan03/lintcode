class Solution {
public:
    /**
     * @param A a string
     * @param B a string
     * @return a boolean
     */
    bool stringPermutation(string& A, string& B) {
        // Write your code here
        if (A.length() != B.length()) {
            return false;
        }

        unordered_map<char, int> count;

        for (const auto& c: A) {
            ++count[tolower(c)];
        }

        for (const auto& c: B) {
            --count[tolower(c)];
            if (count[tolower(c)] < 0) {
                return false;
            }
        }

        return true;
    }
};
