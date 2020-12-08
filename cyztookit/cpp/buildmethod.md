c++ -fPIC -o native.o -c native.cpp
c++ native.o -shared -o libnative.so
