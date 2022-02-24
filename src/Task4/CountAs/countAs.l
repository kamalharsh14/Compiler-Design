%{
int count=0;
%}
%%
[aA] {count++;}
%%
int yywrap(){}
int main(){
printf("Enter String: ");
yylex();
printf("\nNo.of times a occuring: %d \n", count); 
}
