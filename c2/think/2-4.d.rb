def inversion(arr , from = 0 , to = arr.length , result)
	if from >= to
		return
	end
	m = (from + to) / 2
	inversion(arr , from , m , result)
	inversion(arr,  m + 1 , to , result)
	combine(arr, from, m , to, result)
end

def combine(arr , from , middle , to , result)

	left = arr[from..middle]
	right = arr[middle+1..to]

	i = from
	left_i = right_i = 0
	while left_i < left.length and right_i < right.length
		if left[left_i] < right[right_i]
			arr[i] = left[left_i]
			left_i += 1
		else
			arr[i] = right[right_i]
			result.concat(left[left_i..left.length-1].map { |e| "(#{e},#{right[right_i]})" }) 	
			right_i += 1
		end
		i += 1
	end

	left_i.upto(left.length - 1) do |value|
		result.concat(right.map { |e|  "(#{left[value]},#{e})"})
		arr[i] = left[value]
		i += 1
	end
	arr[i..to] = right[right_i..right.length - 1] if right_i < right.length
end

res = []
a = [2,3,8,6,1]
inversion(a , res)
p res.uniq