#include <stdio.h>
#include <stdlib.h>

void swap(char *x, char *y)
{
    char temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

int toint(char* a){
  int i = 0;
  int val = 0;
  for(i = 0 ; i < 5 ; i++){
    val = val*10;
    val += (a[i] - '0' );
  }
  return val;
}

void permute(char *a, int l, int r, int** arr, int* min_dist, int* ans){

   int i,j,k;
   int dist = 0;
   if (l == r){
      //printf("%s\n", a);
      k = 0;
      for (i = 0 ; i < 5 ; i++){
        j = a[i] - '0';
        dist = dist + arr[k][j];
        k = j;
      }
      dist += arr[0][k];
      //printf("%s ----> %d\n", a,dist);
      if(dist < *min_dist){
        //printf("%s ----> %d\n", a,dist);
        *ans = toint(a);
        *min_dist = dist;
      }
   }

   else
   {
       for (i = l; i <= r; i++)
       {
          swap((a+l), (a+i));
          permute(a, l+1, r , arr, min_dist, ans);
          swap((a+l), (a+i)); //backtrack
       }
   }
}

void permute2(char *a, int l, int r, int** arr, int* min_dist, char names[6][15]){

   int i,j,k;
   int dist = 0;
   if (l == r){
      //printf("%s\n", a);
      k = 0;
      for (i = 0 ; i < 5 ; i++){
        j = a[i] - '0';
        dist = dist + arr[k][j];
        k = j;
      }
      dist += arr[0][k];

      //printf("%s ----> %d\n", a,dist);
      if(dist == *min_dist){
        //printf("%s ----> %d\n", a,dist);
        //*ans = toint(a);
        //*min_dist = dist;

        int ans = toint(a);
        int b,c,d,e,f;
        e = ans%10;
        ans = ans/10;
        d = ans%10;
        ans = ans/10;
        c = ans%10;
        ans = ans/10;
        b = ans%10;
        ans = ans/10;
        f = ans%10;
        //printf("%d %d %d %d %d \n", f,b,c,d,e);
        printf("The route is : Charlotte -> %s -> %s -> %s -> %s -> %s -> Charlotte \n", names[f] , names[b] , names[c] , names[d], names[e]);

      }
   }

   else
   {
       for (i = l; i <= r; i++)
       {
          swap((a+l), (a+i));
          permute2(a, l+1, r , arr, min_dist, names);
          swap((a+l), (a+i)); //backtrack
       }
   }
}



int main()
{
    
    int** arr = (int**)malloc(6 * sizeof(int*));
    
    int i,j;
    
    for(i = 0 ; i < 6 ; i++){
      arr[i] = (int*)malloc(6* sizeof(int));
    }

    for(i=0;i<6;i++){
      arr[i][i] = 0;
    }

    arr[0][1] = 388;
    arr[0][2] = 474;
    arr[0][3] = 533;
    arr[0][4] = 587;
    arr[0][5] = 740;

    arr[1][0] = 388;
    arr[1][2] = 166;
    arr[1][3] = 145;
    arr[1][4] = 199;
    arr[1][5] = 352;

    arr[2][0] = 474;
    arr[2][1] = 166;
    arr[2][3] = 245;
    arr[2][4] = 244;
    arr[2][5] = 472;

    arr[3][0] = 533;
    arr[3][1] = 145;
    arr[3][2] = 245;
    arr[3][4] = 82;
    arr[3][5] = 239;

    arr[4][0] = 587;
    arr[4][1] = 199;
    arr[4][2] = 244;
    arr[4][3] = 82;
    arr[4][5] = 268;

    arr[5][0] = 740;
    arr[5][1] = 352;
    arr[5][2] = 472;
    arr[5][3] = 239;
    arr[5][4] = 268;

    char str[] = "12345";
    int ans = 12345;
    int min_dist = 10000;
    permute(str, 0, 4, arr , &min_dist, &ans);
    //printf("%d ---- %d \n", min_dist, ans);
    
    char names[6][15] = {"Charlotte" , "Jacksonville" , "Tallahasse", "Orlando" , "Tampa" , "Miami"};

    printf("The minimum distance is : %d \n", min_dist);

    permute2(str, 0,4,arr,&min_dist, names);
/*
    int a, b,c,d,e;
    e = ans%10;
    ans = ans/10;
    d = ans%10;
    ans = ans/10;
    c = ans%10;
    ans = ans/10;
    b = ans%10;
    ans = ans/10;
    a = ans%10;*/
    //printf("%d %d %d %d %d \n", a,b,c,d,e);
    //printf("The route is : Charlotte -> %s -> %s -> %s -> %s -> %s -> Charlotte \n", names[a] , names[b] , names[c] , names[d], names[e]);
    return 0;

}
