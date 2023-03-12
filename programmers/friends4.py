def deleteBlock(m, n, board, delete_block):
    for i in range(m):
        board[i] = list(board[i])
    for b in delete_block:
        board[b[0]][b[1]] = "0"
    for i in range(m):
        board[i] = "".join(board[i])
        
    return board

def downBlock(m, n, board):
    for i in range(m):
        board[i] = list(board[i])
        
    for i in range(n):
        idx1 = m-1
        while idx1 > 0:
            if board[idx1][i] != "0":
                idx1 -= 1
            else:
                break
        if idx1 == 0:
            continue
        idx2 = idx1
        
        for j in range(idx1, 0, -1):
            if board[j-1][i] != "0":
                board[idx2][i] = board[j-1][i]
                board[j-1][i] = "0"
                idx2 -= 1
                
    for i in range(m):
        board[i] = "".join(board[i])
    
    return board
                    

def solution(m, n, board):
    answer = 0
    
    while True:
        delete_block = set()
        for i in range(m-1):
            for j in range(n-1):
                if board[i][j] != "0" and board[i][j] == board[i][j+1] and board[i][j+1] == board[i+1][j] and board[i+1][j] == board[i+1][j+1]:
                    delete_block.add((i, j))
                    delete_block.add((i, j+1))
                    delete_block.add((i+1, j))
                    delete_block.add((i+1, j+1))
                    
        delete_block = sorted(delete_block)
        if len(delete_block) == 0:
            break
        
        answer += len(delete_block)
        board = deleteBlock(m, n, board, delete_block)
        board = downBlock(m, n, board)
        
    
    return answer