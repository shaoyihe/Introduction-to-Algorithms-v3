def find_max_sub_array(arr)
	max = nil
	left = nil
	right = nil

	sum = 0
	arr.each_index do |index|
		index.upto(arr.length - 1) do |n|
			sum += arr[n]
			if max.nil? || sum > max
				max = sum
				left = index
				right = n		 				
			end 			
		end
		sum = 0
	end

	return left, right , max
end

p find_max_sub_array([13, -3 , -25, 20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7])
p find_max_sub_array((-10..-1).to_a)