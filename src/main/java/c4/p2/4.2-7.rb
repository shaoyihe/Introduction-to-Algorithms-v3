def complex_multiple(a, b , c , d)
	e = ( a - b) * c
	f = (a + b ) * d
	g = ( c +d )* a
	return g - f , g - e
end

p complex_multiple(1 , 2, 3, 4)