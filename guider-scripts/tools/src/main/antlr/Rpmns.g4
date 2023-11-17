grammar Rpmns;

@header { package cn.bytengine.guider.scripts.antlr; }

project:ID WS L projectDescription* WS R EOF;
projectDescription:app WS;

app: ID WS L appDescription* R;
appDescription: WS;

ID: [a-zA-Z0-9_]+;
L: '{' -> skip ;
R: '}' -> skip ;
WS : [ \t\r\n]+ -> skip ;