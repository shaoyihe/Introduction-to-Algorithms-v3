def find_max_sub_array(arr)
	max , left ,right = arr[0] , 0 , 0
	# contain most right value's  max value
	contain_max , contail_left, contain_right = arr[0] , 0 , 0

	1.upto(arr.length - 1 ) do |index|
		cur = arr[index]
		
		if cur > contain_max + cur
			contain_max , contail_left, contain_right = cur , index , index
		else
			contain_max , contain_right = contain_max + cur , index			
		end

		if contain_max > max
			max , left ,right = contain_max , contail_left, contain_right
		end
	end

	return left ,right , max
end

p find_max_sub_array([13, -3 , -25, 20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7])
p find_max_sub_array((-10..-1).to_a)