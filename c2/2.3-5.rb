def binary_search(arr, target, from = 0 ,to = arr.length - 1)
	if from > to
		return -1
	end

	m = (from+to)/2
	if arr[m] > target
		return binary_search(arr, target, from, m - 1)
	elsif arr[m] < target
		return binary_search(arr, target, m + 1, to)		
	else
		return m	
	end	
end

p binary_search((1..10).to_a , 9)