#include<iostream>

using namespace std;

/*
 * Finds all pythagorean triples in the
 * given array of integers
 *
 * Assume array is sorted
 */

void find_all_pythagorean_triples() {

    // Sort array if not sorted - O(n log n)
    int test_arr[] = {1,3,4,5,6,7,8,10,11};

    int len = sizeof(test_arr)/sizeof(int);

    // Square array
    for(int i = 0; i < len; i++) {

        test_arr[i] = test_arr[i]*test_arr[i];
        cout << test_arr[i] << " ";    
    }

    // Problem reduces to finding target sum

    for(int i = 2; i < len; i++) {

        int j = 0, k = i-1;

        while(j < k) {

            if(test_arr[j] + test_arr[k] < test_arr[i])
                j++;

            if(test_arr[j] + test_arr[k] > test_arr[i])
                k--;

            else if(test_arr[j] + test_arr[k] == test_arr[i]){
              cout << "Pythagorean Triple " << test_arr[j] << " " << test_arr[k] << endl;
              break;
            }
        }
    }
}

int main() {

        find_all_pythagorean_triples();
}
