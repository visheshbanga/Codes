//Declare two arrays of size 8000 and 16000 in decreasing order and find time taken in sorting the arrays using bubble sort.
#include<sys/time.h>
#include<stdio.h>
struct timeval start,end; // for more info -> command: man gettimeofday (-on uinux)

void bubble_Sort(int a[],int size)
{
	int i,j;
	for(i=0;i<size;i++)
  {
		for(j=0;j<size-i-1;j++)
		{
			if(a[j]>a[j+1])
			{
				a[j]=a[j]^a[j+1];
				a[j+1]=a[j+1]^a[j];
				a[j]=a[j]^a[j+1];
			}
		}
	}
}

int main()
{
	int a[8000],b[16000],i;
  double t1,t2;
	for(i=0;i<8000;i++) //initialize array in decreasing order
	{
		a[i]=7999-i;
		b[i]=15999-i;
	}
	for(i=8000;i<16000;i++)
		b[i]=15999-i;

	gettimeofday(&start,NULL); //get start time
	bubble_Sort(a,8000);
	gettimeofday(&end,NULL); //get end time
  //It returns time in sec and usec. Convert sec to usec by multiplying with 1000000
  t1=((end.tv_sec*1000000+end.tv_usec)-(start.tv_sec*1000000+start.tv_usec)); //time taken (end time - start time)

  gettimeofday(&start,NULL); //for second array
	bubble_Sort(b,16000);
	gettimeofday(&end,NULL);
  t2=((end.tv_sec*1000000+end.tv_usec)-(start.tv_sec*1000000+start.tv_usec));
	printf("Time taken to sort array with 8000 numbers= %f usec\nTime taken to sort array with 16000 numbers= %f usec\n",t1,t2);
  printf("%f\n",t2/t1); //ratio = O((2n)^2)/O(n^2)= 4 (approx)
}
