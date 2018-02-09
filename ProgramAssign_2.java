/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.*;

/**
 *
 * @author mithil
 */
public class ProgramAssign_2
{

    
    public static int computeopt(int opt)
    {
    if (opt == 1)
        {
            System.out.println("--Computing for N = 10000--");
            return 10000;
        }
    else 
        if (opt == 2)
        {
            System.out.println("--Computing for N = 100000--");
            return 100000;
        }
    else
        {
            System.out.println("--Computing for N = 1000000--");
            return 1000000;
        }
    }
    
    public static int CompCountQuickSortSelect=0;
    public static int CompCountQuickSelect=0;
    public static int CompCountLinearSelect=0;
    
        public static void main(String[] args) throws IOException
        {
            double startTime,endTime,totalTime;
            int kth_smallest;
            int len;
            // TODO code application logic here
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("");
            System.out.println("----- Select Value of N from Following: -------");
            System.out.println("1. 10000");
            System.out.println("2. 100000");
            System.out.println("3. 1000000");
            System.out.println("NOTE : ENTER INPUT IN PROPER FORMAT (LOOK IN RESULT PFD) ELSE IT THORW AN ERROR . ");
            int opt =Integer.parseInt(br.readLine());
            len = computeopt(opt);
            int k=len/2;
            int aQuickSort[]=new int[len];
            int aQuickSelect[]=new int[len];
            int aLinearSelect[]=new int[len];
            for(int i=0;i<len;i++)
            {
                int t=(int)(Math.random()*len);
                aQuickSort[i]=t;
                aQuickSelect[i]=t;
                aLinearSelect[i]=t;
            }
                        
         
    //---------QUICK SORT------------
            System.out.println("");
            System.out.println("SELECT 1 - ALGORITHM  = QUICKSORT");
            startTime=System.nanoTime();
            select_QuickSort(aQuickSort,0,len-1);
            kth_smallest=aQuickSort[k];
            endTime=System.nanoTime();
            totalTime=(endTime-startTime)/1000000.0;
            System.out.println("    N = "+len+"\n"+"    K = "+k+"\n"+"    A["+k+"] = "+kth_smallest+"\n"+"    Comparisons = "+CompCountQuickSortSelect+"\n"+"    TIME "+totalTime+"ms");
            
            

//--------------QUICK SELECT---------
            System.out.println("");
            System.out.println("\n SELECT 2 - ALGORITHM  = QUICKSELECT");
            startTime=System.nanoTime();
            kth_smallest=select2(aQuickSelect,0,len-1,k);
            endTime=System.nanoTime();
            totalTime=(endTime-startTime)/1000000.0;
            System.out.println("    N = "+len+"\n"+"    K = "+k+"\n"+"    A["+k+"] = "+kth_smallest+"\n"+"    Comparisons = "+CompCountQuickSelect+"\n"+"    TIME "+totalTime+"ms");
            
            
            
            
//--------------LINEAR SELECT----------
            System.out.println("\n SELECT 3 - ALGORITHM  = Linear Select");
            startTime=System.nanoTime();
            kth_smallest=select3(aLinearSelect,0,len-1,k);
            endTime=System.nanoTime();
            totalTime=(endTime-startTime)/1000000.0;
            System.out.println("    N = "+len+"\n"+"    K = "+k+"\n"+"    A["+k+"] = "+kth_smallest+"\n"+"    Comparisons = "+CompCountLinearSelect+"\n"+"    TIME "+totalTime+"ms");
            
    }
         public static boolean compareSelect1(int x,int y)
    {
        CompCountQuickSortSelect=CompCountQuickSortSelect+1;
        if(x<y)
        {
           return(true); 
        }
        else
        {
            return(false);
        }
    }
    public static boolean compareSelect2(int x,int y)
    {
        CompCountQuickSelect=CompCountQuickSelect+1;
        if(x<y)
        {
           return(true); 
        }
        else
        {
            return(false);
        }
    }
        public static boolean compareSelect3(int x,int y)
    {
        CompCountLinearSelect=CompCountLinearSelect+1;
        if(x<y)
        {
           return(true); 
        }
        else
        {
            return(false);
        }
    }
        
        
   //-----------------------------------------------------------------------     
    public static void select_QuickSort(int a[],int strt,int end)
    {
        int i,j;
        if(strt>=end)
        {
            return;
        }
        else
        {
            int range = end-strt;
            int p=(int)(Math.random()*range)+strt;
            int v=a[p];
            swap(a,strt,p);
            i=strt+1;
            j=end;
            while(i<=j)
            {
                if(compareSelect1(a[i],v))
                    i++;
                else 
                if(a[j]>v)
                    j--;
                else
                {
                    swap (a, i,j);
                    i++;
                    j--;
                }
            }
            swap (a,j,strt); 
            select_QuickSort(a,strt,j);
            select_QuickSort(a,j+1,end);
        }
    }
    
    
    
    public static void swap(int[] array, int i, int j) 
                    {
                        int t = array[i];
                        array[i] = array[j];
                        array[j] = t;
	    
                    }
    
    //-----------------------------------------
    public static int select2(int arr2[],int s,int e,int k)
    {
        if(arr2.length<25)
        {
            int i,j;
            for(i=1;i<=e;++i)
            {
                for(j=i;j>0;--j)
                {
                    if(compareSelect2(arr2[j],arr2[j-1]))
                    {
                        swap(arr2,j,j-1);
                    }
                    else
                    {
                        break;
                    }
                }
            }
            return(arr2[k]);
        }
        else
        {
            return(quickSelect(arr2,s,e,k));
        }
    }
    
    
   
    public static int quickSelect(int arr2[],int s,int e,int k)
    {
        int i,j;
        int pp=(int)(Math.random()*(e-s))+s;
        int pivot=arr2[pp];
        swap(arr2,s,pp);
        i=s+1;
        j=e;
        while(i<=j)
        {
            if(compareSelect2(arr2[i],pivot))
            {
                i++;
            }
            else if(arr2[j]>pivot)
            {
                j--;
            }
            else
            {
                swap(arr2,i,j);
                i++;
                j--;
            }
        }
        swap(arr2,j,s);
        
        if(k<j)
        {
            return(quickSelect(arr2,s,j,k));
        }
        else if(k>j)
        {
            return(quickSelect(arr2,j+1,e,k));
        }
        else
        {
            return(arr2[k]);
        }
    }
    
    //---------------------------------------------
    public static int select3(int arr3[],int s,int e,int k)
    {
        int i,j;
        if(arr3.length<25)
        {
            for(i=1;i<=e;++i)
            {
                for(j=i;j>0;--j)
                {
                    if(compareSelect3(arr3[j],arr3[j-1]))
                    {
                        swap(arr3,j,j-1);
                        
                    }
                    else
                    {
                        break;
                    }
                }
            }
            return(arr3[k]);
        }
        else
        {
            int pivot=linearSelect(arr3,s,e+1);
            i=s+1;
            j=e;
            while(i<=j)
            {
                if(compareSelect3(arr3[i],pivot))
                {
                    i++;
                }
                else if(arr3[j]>pivot)
                {
                    j--;
                }
                else
                {
                    swap(arr3,i,j);                    
                    i++;
                    j--;
                }
            }
            swap(arr3,j,s);            
            if(k<j)
            {
                return(linearSelect1(arr3,s,j,k));
            }
            else if(k>j)
            {
                return(linearSelect1(arr3,j+1,e,k));
            }
            else
            {
                return(arr3[k]);
            }
        }
    }
    public static int linearSelect(int arr3[],int s,int e)
    {
        if(e!=1)
        {
            int i,j,t,mod,f=e/5;
            if((mod=e%5)!=0)
            {
                f=f+1;
            }
            for(i=0;i<f;++i)
            {
                if(i==f-1 && mod!=0)
                {
                    bubbleSort(arr3,i*5,i*5+mod);
                    t=arr3[i];
                    arr3[i]=arr3[((5*i)+(i*5+mod))/2];
                    arr3[((5*i)+(i*5+mod))/2]=t;
                }
                else
                {
                    bubbleSort(arr3,i*5,i*5+5);
                    t=arr3[i];
                    arr3[i]=arr3[((5*i)+(i*5+5))/2];
                    arr3[((5*i)+(i*5+5))/2]=t;
                }
            }
            return(linearSelect(arr3,s,f));
        }
        else
        {
            return(arr3[s]);
        }
    }
    public static void bubbleSort(int a[],int s,int e)
    {
        int i,j,t,len=e;
        for(i=s;i<len;++i)
        {
            for(j=s;j<(len-i-1)+i;++j)
            {
                if(compareSelect3(a[j+1],a[j]))
                {
                    t=a[j]; 
                    a[j]=a[j+1];
                    a[j+1]=t;
                }
            }
        }
    }
    public static int linearSelect1(int arr2[],int s,int e,int k)
    {
        int i,j,temp;
        int pp=(int)(Math.random()*(e-s))+s;
        int pivot=arr2[pp];
        swap(arr2,s,pp);
        
        i=s+1;
        j=e;
        while(i<=j)
        {
            if(compareSelect3(arr2[i],pivot))
            {
                i++;
            }
            else if(arr2[j]>pivot)
            {
                j--;
            }
            else
            {
                swap(arr2,i,j);
                i++;
                j--;
            }
        }
        temp=arr2[j];
        arr2[j]=arr2[s];
        arr2[s]=temp;
        if(k<j)
        {
            return(linearSelect1(arr2,s,j,k));
        }
        else if(k>j)
        {
            return(linearSelect1(arr2,j+1,e,k));
        }
        else
        {
            return(arr2[k]);
        }
    }
   
    
}
