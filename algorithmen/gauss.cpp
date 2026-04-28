
#include <bits/stdc++.h>
#include <iostream>

using namespace std;
#define key(a,b) (( (unsigned long long)(a) << 32 ) | (unsigned long long)(b))



int main() {
    long long n= 1000000LL;

    auto start = chrono::high_resolution_clock::now();
    vector<bool> isprime(n + 1, true);
    isprime[0] = false;
    isprime[1]=false;
    unordered_set<long long> s;
    for (long long i = 2; i*i <= n; i++) {
        if (isprime[i]) {
            for (int j = i*i; j <= n; j+=i) {
                isprime[j]=false;
            }
        
        }
    }

    for (int i = 2; i <= n; i++) {
        if (isprime[i]) {

         s.insert(key(0,i));
         s.insert(key(i,0));
        }
    }


    for (long long  i = 1; i*i < n; i++) {
        for (int j = 1; j*j < n-i*i; j++) {
            if (gcd(i, j)!=1) {
                continue;
            }
            if (isprime[i*i+j*j]) {
                
                s.insert(key(i,j));
            }
        }
    }
    auto end = chrono::high_resolution_clock::now();
    chrono::duration<double> diff = end - start;

    cout << "Zeit: " << diff.count() << " Sekunden\n";
    ofstream out("output.txt");
    int lim = 600;
        for (int i = -lim; i < lim; i++) {
            for (int j = -lim; j < lim; j++) {
                if (s.count(key(abs(i), abs(j)))) {
                    out << "██";
                } else {
                    out << "  ";
                }
            }
            out << "\n";
        }

        out.close();

    ofstream out2("output2.txt");
        for (int i = 0; i < 2*lim; i++) {
            for (int j = 0; j < 2*lim; j++) {
                if (s.count(key(abs(i), abs(j)))) {
                    out2 << "██";
                } else {
                    out2 << "  ";
                }
            }
            out2 << "\n";
        }

        out2.close();




    return 0;
}

