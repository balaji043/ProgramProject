#include<iostream>
using namespace std;
int ans=0;
void checkarray(int p[], int n)
{
    int i,ff,bol=0,k=0;
	for(int j=0;j<n;j++)
        {
            if(p[j]!=1)
            {
                for(i = 2; i <= p[j]/2; ++i)
                    {
                        if(p[j]%i==0)
                        {
                            bol = 1;
                            break;
                        }
                    }
            }   else   {   bol=1;  }
            if (bol==0)
                {
                    k++;
                }
                bol=0;
        }
    if(k>=2)
    {
        ans++;
    }
    k=0;
}
void partitonnum(int n,int m)
{
	int p[n];
	int k = 0,count1=0;
	p[k] = n;
	while (true)
	{
        if(k==m){checkarray(p, k+1);}
		int rem=0;
		while (k>=0&&p[k]==1)
		{
			rem+=p[k];
			k--;
		}
		if(k<0) return;
		p[k]--;
		rem++;
        while(rem>p[k])
		{
			p[k+1]=p[k];
			rem=rem-p[k];
			k++;
		}
        p[k+1]=rem;
		k++;
	}
}
int main()
{
    int num,dd;
    cin>>num;
	cin>>dd;
	dd=dd-1;
	partitonnum(num,dd);
	cout<<ans<<" ";
	return 0;
}
