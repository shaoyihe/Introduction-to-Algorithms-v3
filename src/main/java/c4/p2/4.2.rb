require("matrix")

Pos = Struct.new(:row, :column)

def square_marix(a , b, a_f_pos = Pos.new(0 , 0) , a_t_pos = Pos.new(a.length - 1, a[0].length - 1), 
	b_f_pos = Pos.new(0 , 0) , b_t_pos = Pos.new(b.length - 1, b[0].length - 1 ))
	c = Matrix.build(a_t_pos.row - a_f_pos.row + 1){nil}.to_a
	if condition
		
	end
end


p Pos.new