#include <stdio.h>
#include <stdbool.h>

int main () {
    // char name[] = "Jubril";
    // printf ("%s", name);
    int n, i;
    long long factorial = 1;

    printf("Enter a positive number: ");
    scanf("%d", &n);

    if (n < 0) {
        printf("Factorial does not work with negative number.");
    } else {
        for (i = 1; i <= n; i++) {
            factorial *= i;
        }
        printf("\nFactorial of %d = %lld.", n, factorial);
    };



    return 0;
}