def insert(arr,pos)
	pos.pred.downto(0).each do |i|
		if arr[i] > arr[i + 1]
			arr[i] , arr[i + 1] = arr[i+ 1] , arr[i]
		else
			break	
		end
	end
end

def recursive_insert_order(arr, pos = arr.length - 1)
	if pos > 0
		recursive_insert_order(arr, pos - 1)
	end
	insert(arr, pos)
end

arr = [2,5,4,2,7,10,-1,-9]
recursive_insert_order(arr)
p arr


