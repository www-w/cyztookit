jars=$(find . -type f -name "*.jar"|tr '\n' ':')
echo "$jars"
if [ -z $jars ];
then
    echo find;
else
    echo not;
fi

