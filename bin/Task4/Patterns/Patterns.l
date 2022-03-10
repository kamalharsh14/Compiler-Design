%{
int aa_c=0;
int ab_c=0;
int a_c=0;
%}

%%
aa+ {aa_c++; a_c++;}
a+b+ {ab_c++; a_c++;}
. ;
%%

int yywrap(){}
int main(){
printf("Enter string: ");
yylex();
printf("\nOutput: \n");
if(aa_c ==1) printf(" Contains 'aa' \n");
else printf("Doesn't contain 'aa' \n");
if(ab_c ==1) printf("Contains 'ab' \n");
else printf("Doesn't contain 'ab' \n");
if(a_c ==0) printf("Doesn't contains 'a' \n");
else printf("Contains 'a' \n");
return 0;
}
