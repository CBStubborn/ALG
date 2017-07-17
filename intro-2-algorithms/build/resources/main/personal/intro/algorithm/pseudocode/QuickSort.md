# 快速排序伪代码 #

---

```
QuickSort(A, p, r)
  if p<r
      q = Partition(A, p, r)
      QuickSort(A, p, q - 1)
      QuickSort(A, q + 1, r)
```

其中，partition 算法伪代码描述如下
```
Partition(A, p, r)
  x = A[r]
  i = p - 1
  for j = p to r -1
      if A[j] <= x
          i += 1
          exchange A[i] wwith A[j]
  exchange A[i + 1] with A[r]
  return i + 1
```

---