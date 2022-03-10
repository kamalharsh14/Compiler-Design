%{
int lc=0,sc=0,tabs=0;
%}
%%
\n lc++;
([ ])+ sc++;
\t tabs++;
%%
int yywrap(){}
int main(){
yylex();
printf("\nNo. of lines=%d", lc); 
printf("\nNo. of spaces=%d", sc);
printf("\nNo. of tabs=%d", tabs);
}
