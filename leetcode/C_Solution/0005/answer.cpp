#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    string s;
    int checkPalindrome(string &s, int start, int end, int isPalindrome[1000][1000])
    {
        if (isPalindrome[start][end] != 0)
        {
            return isPalindrome[start][end];
        }
        int len = end - start + 1;
        if (len <= 1)
        {
            isPalindrome[start][end] = 1;
        }
        else if (s.at(start) == s.at(end))
        {

            isPalindrome[start][end] = checkPalindrome(s, start + 1, end - 1, isPalindrome);
        }
        else
        {
            isPalindrome[start][end] = -1;
        }
        return isPalindrome[start][end];
    }
    string longestPalindrome(string s)
    {
        int maxLen = 0;
        int start = 0;
        int end = 0;
        int n = s.length();

        // 0 : not checked
        // 1 : yes
        // -1 : no
        int isPalindrome[1000][1000] = {0};

        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                int len = j - i + 1;
                if (maxLen < len && checkPalindrome(s, i, j, isPalindrome) == 1)
                {
                    maxLen = len;
                    start = i;
                    end = j;
                }
            }
        }
        // cout << "start :" << start << " end : " << end << endl;
        return s.substr(start, end - start + 1);
    }
};

int main()
{
    Solution Solution;
    // cout << Solution.longestPalindrome("babad") << endl;
    cout << Solution.longestPalindrome("anugnxshgonmqydttcvmtsoaprxnhpmpovdolbidqiyqubirkvhwppcdyeouvgedccipsvnobrccbndzjdbgxkzdbcjsjjovnhpnbkurxqfupiprpbiwqdnwaqvjbqoaqzkqgdxkfczdkznqxvupdmnyiidqpnbvgjraszbvvztpapxmomnghfaywkzlrupvjpcvascgvstqmvuveiiixjmdofdwyvhgkydrnfuojhzulhobyhtsxmcovwmamjwljioevhafdlpjpmqstguqhrhvsdvinphejfbdvrvabthpyyphyqharjvzriosrdnwmaxtgriivdqlmugtagvsoylqfwhjpmjxcysfujdvcqovxabjdbvyvembfpahvyoybdhweikcgnzrdqlzusgoobysfmlzifwjzlazuepimhbgkrfimmemhayxeqxynewcnynmgyjcwrpqnayvxoebgyjusppfpsfeonfwnbsdonucaipoafavmlrrlplnnbsaghbawooabsjndqnvruuwvllpvvhuepmqtprgktnwxmflmmbifbbsfthbeafseqrgwnwjxkkcqgbucwusjdipxuekanzwimuizqynaxrvicyzjhulqjshtsqswehnozehmbsdmacciflcgsrlyhjukpvosptmsjfteoimtewkrivdllqiotvtrubgkfcacvgqzxjmhmmqlikrtfrurltgtcreafcgisjpvasiwmhcofqkcteudgjoqqmtucnwcocsoiqtfuoazxdayricnmwcg") << endl;
    return 0;
}