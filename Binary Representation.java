class Solution {
public:
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    string binaryRepresentation(string n) {
        // wirte your code here
        size_t pointPos = n.find(".");
                double decimal = 0.0;
                int integer = 0;
                if (pointPos == string::npos) {
                        integer = atoi(n.c_str());
                }
                else {
                        string intPart = n.substr(0, pointPos);
                        string decPart = n.substr(pointPos, n.size());
                        integer = atoi(intPart.c_str());
                        decimal = strtod(decPart.c_str(), NULL); // atod not support
                }
                string intBuf;
                string decBuf;
                if (integer > 0) {
                        while (integer != 0) {
                                intBuf.append(integer & 1 == 1 ? "1" : "0");
                                integer >>= 1;
                        }
                        reverse(intBuf.begin(), intBuf.end());
                }
                else {
                        intBuf.append("0");
                }
                while (decimal > 0.0) {
                        if (decBuf.size() > 32) {
                                return "ERROR";
                        }
                        decimal *= 2;
                        if (decimal >= 1.0) {
                                decBuf.append("1");
                                decimal -= 1.0;
                        }
                        else {
                                decBuf.append("0");
                        }
                }
                return decBuf.size() > 0 ? intBuf + "." + decBuf : intBuf;
    }
};

