class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 0;
        a--;
        b--;
        while(a != b){
            a/=2;
            b/=2;
            cnt++;
        }
        return cnt;
    }
}