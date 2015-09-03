def find_max_sub_array(arr , from = 0 , to = arr.length - 1)
	if to == from
		return from, to , arr[from]
	end

	m = (from + to) / 2
	(left_f, left_r, left_m) = find_max_sub_array(arr , from , m )
	(right_f, right_r, right_m) = find_max_sub_array(arr , m + 1 , to )
	(cross_f, cross_r, cross_m) = find_cross_max_sub_array(arr, from, m , to)

	if left_m >= right_m && left_m >= cross_m
		return left_f, left_r, left_m
	elsif right_m >= left_m && right_m >= cross_m
		return right_f, right_r, right_m
	else
		return cross_f, cross_r, cross_m			
	end

end

def find_cross_max_sub_array(arr, from , m, to)
	left_max = nil
	left_from = nil
	sum = 0
	m.downto(from) do |i|
		sum += arr[i]
		if left_max.nil? || sum > left_max
			left_max = sum
			left_from = i
		end
	end

	right_max = nil
	right_to = nil
	sum = 0
	m.succ.upto(to) do |i|
		sum += arr[i]
		if right_max.nil? || sum > right_max
			right_max = sum
			right_to = i
		end
	end
	left_max = 0 if left_max.nil?
	right_max = 0 if right_max.nil?
	return left_from, right_to, (left_max + right_max)
end

p find_max_sub_array([13, -3 , -25, 20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7])
p find_max_sub_array((-10..-1).to_a)
